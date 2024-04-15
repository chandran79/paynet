package jai.framework.bootstrap;

import jai.framework.domain.Product;
import jai.framework.repositories.ProductRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//added from local
//second line
//second line modified


@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;


    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Lenovo Laptop E304");
        shirt.setPrice(new BigDecimal("2500.00"));
        shirt.setImageUrl("https://www.lenovo.com/images/rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Lenovo: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Apple Macbook 3inch 2018");
        mug.setImageUrl("https://www.apple.com/images/j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("4300.00"));
        productRepository.save(mug);

        log.info("Saved Macbook :" + mug.getId());
    }


}



