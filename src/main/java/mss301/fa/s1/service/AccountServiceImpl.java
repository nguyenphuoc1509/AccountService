package mss301.fa.s1.service;

import mss301.fa.s1.model.Account;
import mss301.fa.s1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(int id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setAccountID(id);
            return accountRepository.save(account);
        }
        return null;
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account findByAccountName(String accountName) {
        return accountRepository.findByAccountName(accountName);
    }

    @Override
    public List<Account> findByRoleId(int roleId) {
        return accountRepository.findByRoleRoleId(roleId);
    }

    @Override
    public List<Account> findByRoleName(String roleName) {
        return accountRepository.findByRoleRoleName(roleName);
    }

    @Override
    public List<Account> searchAccountsByEmail(String emailPattern) {
        // giữ nguyên như ảnh
        return accountRepository.findByAccountNameContaining(emailPattern);
        // nếu bạn muốn search theo email thực sự, đổi thành:
        // return accountRepository.findByEmailContaining(emailPattern);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return accountRepository.existsByEmail(email);
    }
}

