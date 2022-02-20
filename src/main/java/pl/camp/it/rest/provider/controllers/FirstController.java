package pl.camp.it.rest.provider.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.rest.provider.model.Address;
import pl.camp.it.rest.provider.model.User;
import pl.camp.it.rest.provider.model.dto.UserResponse;

@RestController
public class FirstController {

    @RequestMapping(value = "/cos", method = RequestMethod.GET)
    public void cos() {
        System.out.println("Coś się dzieje !!!");
    }

    @RequestMapping(value = "/cos2", method = RequestMethod.GET)
    public User user() {
        User user = new User();
        user.setId(12);
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setAge(50);

        Address address = new Address("Jakaś", "23-232", "Warszawa");

        user.setAddress(address);

        return user;
    }

    @RequestMapping(value = "/cos4", method = RequestMethod.POST)
    public User user2(@RequestBody User user) {
        user.setId(15);

        return user;
    }

    @RequestMapping(value = "/user/{id}/{id2}", method = RequestMethod.POST)
    public User changeUser(@RequestBody User user,
                           @PathVariable int id,
                           @PathVariable int id2,
                           @RequestParam String parametr1,
                           @RequestParam String parametr2,
                           @RequestHeader String naglowek1,
                           @RequestHeader String naglowek2) {
        System.out.println("Przyszedł User !!!!");
        System.out.println("Ma na imie :" + user.getName());
        System.out.println("Odmładzam !!!");

        System.out.println("ID: " + id);
        System.out.println("ID2: " + id2);

        System.out.println("parametr1: " + parametr1);
        System.out.println("parametr2: " + parametr2);

        System.out.println("naglowek1: " + naglowek1);
        System.out.println("naglowek2: " + naglowek2);

        user.setAge(10);

        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public UserResponse users() {
        User user = new User(1, "Janusz", "Kowalski", 50);
        User user2 = new User(2, "Karol", "Malinowski", 20);

        UserResponse userResponse = new UserResponse();
        userResponse.getUsers().add(user);
        userResponse.getUsers().add(user2);

        return userResponse;
    }

    @RequestMapping(value = "/cos3", method = RequestMethod.GET)
    public ResponseEntity<User> cos3() {
        User user = new User();
        user.setId(1);
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setAge(50);

        Address address = new Address("Jakaś", "23-232", "Warszawa");

        user.setAddress(address);

        ResponseEntity<User> response = ResponseEntity.status(404)
                .header("naglowek", "abcd")
                .header("naglowek2", "n2")
                .body(user);

        return response;
    }
}
