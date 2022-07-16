package com.imed.app.ws.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imed.app.ws.entities.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String Userid);
	
	//sql native
	@Query(value="select * from users",nativeQuery = true)
	Page<UserEntity> findAllUser(Pageable pageableRequest);
	
	//jpql
	//@Query("SELECT user FROM UserEntity user")
	//Page<UserEntity> findAllUser(Pageable pageableRequest);
	
	
	
	
	//@Query(value="SELECT * FROM users WHERE (users.firstname = ?1 OR users.lastname = ?1) AND users.email_verification_status = ?2",nativeQuery = true)
	//Page<UserEntity> findAllUserCriteria(Pageable pageableRequest,String search,int status);
	
	
	//status not working
	//@Query(value="SELECT * FROM users u WHERE (u.firstname = :search OR u.lastname = :search) AND u.email_verification_status = :status",nativeQuery = true)
	//Page<UserEntity> findAllUserCriteria(Pageable pageableRequest,@Param("search") String search, @Param("status") int status);
	
	//status not working
	@Query(value="SELECT * FROM users WHERE (users.firstname LIKE %:search% OR users.lastname LIKE %:search%) AND users.email_verification_status = :status",nativeQuery = true)
	Page<UserEntity> findAllUserCriteria(Pageable pageableRequest,@Param("search") String search, @Param("status") int status);
	
} 
