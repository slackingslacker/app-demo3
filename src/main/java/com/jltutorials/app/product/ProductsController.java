package com.jltutorials.app.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) throws Exception {
        model.addAttribute("allProducts", getProducts());
        return "products";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductDetail(Model model, @RequestParam(value = "name", defaultValue = "") String name)
        throws Exception {
        Product productFetch = getProducts().stream().filter(product -> name.equals(product.getName())).findFirst().orElse(null);
        model.addAttribute("product", productFetch);
        return "product";
    }


    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", 1f, "An apple is a sweet, edible fruit produced by an apple tree."));
        products.add(new Product("Orange", 0.35f, "The orange is the fruit of the citrus species Citrus in the family Rutaceae."));
        products.add(new Product("Banana", 1.3f, "A banana is an edible fruit produced by several kinds of large herbaceous flowering plants in the genus Musa."));
        return products;
    }
}
