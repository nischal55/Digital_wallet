package dao;

import java.util.List;
import models.Wallet;

public interface WalletDAO {
    boolean save(Wallet wallet);
    boolean update(Wallet wallet);
    boolean deleteById(Long id);
    List<Wallet>  findAll();
    Wallet findById(Long id);
    Wallet getWalletByUserId(Long id);
    boolean transferBalance(Long userId, String contact, double transfer_amount);
   
}
