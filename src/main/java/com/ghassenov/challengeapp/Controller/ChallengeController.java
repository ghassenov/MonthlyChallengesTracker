package com.ghassenov.challengeapp.Controller;

import com.ghassenov.challengeapp.Entities.Challenge;
import com.ghassenov.challengeapp.Service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;

    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
       boolean isChallengeAdded = challengeService.addChallenge(challenge);
       if (isChallengeAdded) {
           return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
       }
       else{return new ResponseEntity<>("Challenge not added",HttpStatus.NOT_FOUND);}

    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable long id,@RequestBody Challenge updatedChallenge) {
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updatedChallenge);
        if (isChallengeUpdated) {
            return new ResponseEntity<>("Challenge updated successfully",HttpStatus.OK);
        }
        else{return new ResponseEntity<>("Challenge not updated",HttpStatus.NOT_FOUND);}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable long id) {
        boolean isDeleted = challengeService.deleteChallenge(id);
        if (isDeleted) {
            return new ResponseEntity<>("Challenge deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("challenge not deleted",HttpStatus.NOT_FOUND);
        }
    }
}
