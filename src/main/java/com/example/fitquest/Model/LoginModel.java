package com.example.fitquest.Model;

import com.example.fitquest.Model.Data.FQDatabase;
import com.example.fitquest.Model.Data.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class LoginModel {

    private StringProperty errorMessage = new SimpleStringProperty();

    /**
     * Kollar om angett användarnamn finns i databasen och i så fall, om lösenordet stämmer.
     * Returnerar true om användaren hittas och lösenordet stämmer,
     * annars sätts felmeddelande till LogicController:s errorLabel och false returneras.
     * @param username: String
     * @param password: String
     * @return boolean: true om användare hittas och lösenord stämmer, annars false.
     */
    public boolean checkUserCredentials(String username, String password) {

        // Hämtar instansen till databasen
        FQDatabase database = FQDatabase.getInstance();
        // Hämtar listan med alla användare
        List<User> users = database.getUsers();

        // Går igenom samltliga användare för att kolla om användarnamnet och lösenordet matchar med någon.
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    // Om både användare hittas och lösenordet matchar så sätts denna användare till currentUser i FQDatabase,
                    // sedan returneras true.
                    database.setCurrentUser(user);
                    return true;
                } else {
                    // om användaren hittas men lösenordet är felaktigt för denna användare
                    // så sätts errorMessage (som är bunden till errorLabel i LoginController - det som sätts här visas alltså i labeln i appen) samt
                    // så returneras false
                    errorMessage.set("Felaktigt lösenord.");
                    return false;
                }
            }
        }
        // om användaren inte hittas
        // så sätts errorMessage (som är bunden till errorLabel i LoginController - det som sätts här visas alltså i labeln i appen) samt
        // så returneras false
        errorMessage.set("Felaktigt användarnamn.");
        return false;
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }
}
