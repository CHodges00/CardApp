package backEnd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backEnd.Models.Brand;
import backEnd.Repos.BrandRepo;

@RestController
@RequestMapping("/brands")
public class BrandController {
    
    @Autowired
    private BrandRepo brandRepo;
    
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }
    
    @PostMapping
    public Brand addBrand(@RequestBody Brand brand) {
        return brandRepo.save(brand);
    }
    
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Long id) {
        brandRepo.deleteById(id);
    }
}