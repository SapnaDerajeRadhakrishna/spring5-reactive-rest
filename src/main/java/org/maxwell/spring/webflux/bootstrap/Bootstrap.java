package org.maxwell.spring.webflux.bootstrap;

import org.maxwell.spring.webflux.domain.Category;
import org.maxwell.spring.webflux.domain.Vendor;
import org.maxwell.spring.webflux.repositories.CategoryRepository;
import org.maxwell.spring.webflux.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final VendorRepository vendorRepository;

	public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
		this.categoryRepository = categoryRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		if (categoryRepository.count().block() == 0) {
			// load data
			log.debug("#### LOADING DATA ON BOOTSTRAP #####");

			categoryRepository.save(Category.builder().description("Fruits").build()).block();

			categoryRepository.save(Category.builder().description("Nuts").build()).block();

			categoryRepository.save(Category.builder().description("Breads").build()).block();

			categoryRepository.save(Category.builder().description("Meats").build()).block();

			categoryRepository.save(Category.builder().description("Eggs").build()).block();

			log.debug("Loaded Categories: {}", categoryRepository.count().block());

			vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build()).block();

			vendorRepository.save(Vendor.builder().firstName("Micheal").lastName("Weston").build()).block();

			vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Waters").build()).block();

			vendorRepository.save(Vendor.builder().firstName("Bill").lastName("Nershi").build()).block();

			vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Buffett").build()).block();

			log.debug("Loaded Vendors: {}", vendorRepository.count().block());

		}

	}

}
