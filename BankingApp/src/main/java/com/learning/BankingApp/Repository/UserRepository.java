package com.learning.BankingApp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learning.BankingApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.id = :userid")
//    User findByUserId(@Param("userid") int userid);
//	 List<Account> findByUserid(Long userid);

}

