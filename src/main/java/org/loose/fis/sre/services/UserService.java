package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("User.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role, int id) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role, id));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static boolean verifyUserId(int userId) {
        for (User user : userRepository.find()) {
            if (userId == user.getUserId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyUsernamePassword(String username, String password) {
        String password1 = encodePassword(username, password);
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                if (password1.equals(user.getPassword()))
                    return true;
            }
        }
        return false;
    }

    public static String checkUserRole(String name) {
        for (User user : userRepository.find()) {
            if (Objects.equals(name, user.getUsername())) {
                return user.getRole();
            }
        }
        return null;
    }

    public static int returnId(String name) {

        for (User user : userRepository.find()) {
            if (name.equals(user.getUsername())) {
                return user.getUserId();
            }
        }
        return -1;
    }

    public static String returnName(int id) {
        for (User user : userRepository.find()) {
            if (id == user.getUserId() && user.getRole().equals("Seller")) {
                return user.getUsername();
            }
        }
        return null;
    }


}
