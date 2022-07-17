package com.imed.app.ws.services;

import java.util.List;

import com.imed.app.ws.shared.dto.AddressDto;

public interface AddressService {

		List<AddressDto>getAllAddresses(String email);
		AddressDto createAddress(AddressDto addressDto,String email);
		AddressDto getAddress(String id);
		void DeleteAddress(String addressId);
}
