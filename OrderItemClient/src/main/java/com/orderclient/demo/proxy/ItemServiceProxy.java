package com.orderclient.demo.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderclient.demo.dto.ItemsDto;


@FeignClient(name="Item-Service")
//@FeignClient(name="Zuul-Gateway-Proxy-Application")
@RibbonClient(name="Item-Service")
public interface ItemServiceProxy {
	
	@GetMapping("/getAllItems")
    public List<ItemsDto> getAllItems(); 
	
	@PostMapping("/createitem")
	public ResponseEntity<ItemsDto> createItem(@RequestBody ItemsDto itemsDto);
}
