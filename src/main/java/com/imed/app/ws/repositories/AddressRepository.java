package com.imed.app.ws.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imed.app.ws.entities.AddressEntity;
import com.imed.app.ws.entities.UserEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

	List<AddressEntity> findByUser(UserEntity currentUser);
	AddressEntity findByAddressId(String AddressId);
	
	//@Query(value="DELETE * FROM addresses WHERE addresses.address_id = ?1;",nativeQuery = true)
	//void deleteId(String addressId);
}
