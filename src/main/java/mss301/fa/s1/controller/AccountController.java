package mss301.fa.s1.controller;


import mss301.fa.s1.model.Account;
import mss301.fa.s1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    // GET /api/accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // GET /api/accounts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/accounts
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    // PUT /api/accounts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(id, account);
        return updatedAccount != null
                ? ResponseEntity.ok(updatedAccount)
                : ResponseEntity.notFound().build();
    }

    // DELETE /api/accounts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/accounts/email/{email}
    @GetMapping("/email/{email}")
    public ResponseEntity<Account> findByEmail(@PathVariable String email) {
        Account account = accountService.findByEmail(email);
        return account != null
                ? ResponseEntity.ok(account)
                : ResponseEntity.notFound().build();
    }

    // GET /api/accounts/name/{accountName}
    @GetMapping("/name/{accountName}")
    public ResponseEntity<Account> findByAccountName(@PathVariable String accountName) {
        Account account = accountService.findByAccountName(accountName);
        return account != null
                ? ResponseEntity.ok(account)
                : ResponseEntity.notFound().build();
    }

    // GET /api/accounts/role/{roleId}
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<Account>> findByRoleId(@PathVariable int roleId) {
        List<Account> accounts = accountService.findByRoleId(roleId);
        return ResponseEntity.ok(accounts);
    }

    // GET /api/accounts/role/name/{roleName}
    @GetMapping("/role/name/{roleName}")
    public ResponseEntity<List<Account>> findByRoleName(@PathVariable String roleName) {
        List<Account> accounts = accountService.findByRoleName(roleName);
        return ResponseEntity.ok(accounts);
    }

    // GET /api/accounts/search?email=abc
    @GetMapping("/search")
    public ResponseEntity<List<Account>> searchByEmail(@RequestParam String email) {
        List<Account> accounts = accountService.searchAccountsByEmail(email);
        return ResponseEntity.ok(accounts);
    }

    // GET /api/accounts/exists/{email}
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkEmailExists(@PathVariable String email) {
        return ResponseEntity.ok(accountService.checkEmailExists(email));
    }
}
