package com.gfg.HTTPTest.controller;

import com.gfg.HTTPTest.user.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/get")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello this is dummy user" );
    }

//    @GetMapping("/getUserById")
//    public ResponseEntity<UserModel> getUserById(@RequestParam int id ) {
//        return ResponseEntity.ok(new UserModel(1, "dummy", "dummy", 1));
//
//    }

    @GetMapping("/getUserById1/{id}")
    public ResponseEntity<UserModel> getUserById1(@PathVariable int id ) {
        return ResponseEntity.ok(new UserModel(1, "dummy", "dummy", 1));

    }

    @GetMapping("/getUserById2")
    public ResponseEntity<UserModel> getUserById2(@RequestParam int id ) {
        return ResponseEntity.ok(new UserModel(1, "dummy", "dummy", 1));

    }


    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        UserModel user = new UserModel(userModel.getId(), userModel.getUserName(), userModel.getEmail(), userModel.getAge());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestParam int id,@RequestBody UserModel userModel) {
        return ResponseEntity.ok("User updated successfully"+ " with user Id: " + userModel.getId() + " userName: "+ userModel.getUserName() + " userEmail:  " + userModel.getEmail() + " userAge: " + userModel.getAge());
    }

    @PatchMapping("/updateUserByPatch")
    public ResponseEntity<String> updateUserPatch(@RequestParam int id,@RequestBody UserModel userModel) {
        return ResponseEntity.ok("Age updated successfully"+ " with user Id: " + id + " userAge: " + userModel.getAge());
    }


    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam int id) {
        return ResponseEntity.ok("User deleted successfully"+ " with user Id: " + id);
    }



}
