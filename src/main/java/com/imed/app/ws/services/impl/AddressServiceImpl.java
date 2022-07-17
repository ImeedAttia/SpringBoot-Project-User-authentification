package com.imed.app.ws.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imed.app.ws.entities.AddressEntity;
import com.imed.app.ws.entities.UserEntity;
import com.imed.app.ws.repositories.AddressRepository;
import com.imed.app.ws.repositories.UserRepository;
import com.imed.app.ws.services.AddressService;
import com.imed.app.ws.shared.Utils;
import com.imed.app.ws.shared.dto.AddressDto;
import com.imed.app.ws.shared.dto.UserDto;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils utils;
	@Override
	public List<AddressDto> getAllAddresses(String email) {
		UserEntity currentUser = userRepository.findByEmail(email);
		
		List<AddressEntity> addresses = currentUser.getAdmin() == true ? (List<AddressEntity>) addressRepository.findAll() : addressRepository.findByUser(currentUser);
		Type listType = new TypeToken<List<AddressDto>>() {}.getType();
		List<AddressDto> addressDto = new ModelMapper().map(addresses, listType);
		return addressDto;
	}
	@Override
	public AddressDto createAddress(AddressDto addressDto, String email) {
		UserEntity currentUser = userRepository.findByEmail(email);
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(currentUser, UserDto.class);
		addressDto.setAddressId(utils.GenerateStringId(30));
		addressDto.setUser(userDto);
		AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
		AddressEntity newAddress = addressRepository.save(addressEntity);
		AddressDto adress = modelMapper.map(newAddress, AddressDto.class);
		
		return adress;
	}
	@Override
	public AddressDto getAddress(String id) {
		AddressEntity addressEntity = addressRepository.findByAddressId(id);
		
		ModelMapper modelMapper = new ModelMapper();
		AddressDto adress = modelMapper.map(addressEntity, AddressDto.class);
		return adress;
	}
	@Override
	public void DeleteAddress(String addressId) {
		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);
		if (addressEntity == null) throw new RuntimeException("Address Not Found");
		addressRepository.delete(addressEntity);
		
	}

}
