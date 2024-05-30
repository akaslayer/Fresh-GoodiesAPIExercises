package com.spring_boot_day2.freshGoodiesAPIExercises.favorite;

import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.model.FavoriteProduct;
import com.spring_boot_day2.freshGoodiesAPIExercises.favorite.services.FavoriteProductServices;
import com.spring_boot_day2.freshGoodiesAPIExercises.products.model.Product;
import com.spring_boot_day2.freshGoodiesAPIExercises.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/favorites/")
@Validated
public class FavoriteProductController {

    private FavoriteProductServices favoriteProductServices;

    public FavoriteProductController(FavoriteProductServices favoriteProductServices) {
        this.favoriteProductServices = favoriteProductServices;
    }

    @PostMapping("toogle")
    public ResponseEntity<Response<FavoriteProduct>> addNewProduct(@Valid @RequestBody FavoriteProduct favoriteProduct){
        String data = favoriteProductServices.toogleFavorite(favoriteProduct);
        if(data.equals("add")){
            return Response.successfulResponse(HttpStatus.CREATED.value(),"Favorite product has been added",favoriteProduct);
        }else{
            return Response.successfulResponse(HttpStatus.CREATED.value(),"Favorite product has been deleted",favoriteProduct);
        }

    }

    @GetMapping("{userId}")
    public ResponseEntity<Response<List<FavoriteProduct>>>  getFavoriteProduct(@PathVariable("userId") int userId){
        List<FavoriteProduct> data = favoriteProductServices.getFavoriteList(userId);
        if(data.isEmpty()){
            return Response.successfulResponse(HttpStatus.OK.value(),"Favorite list is empty",data);
        }
        return Response.successfulResponse(HttpStatus.OK.value(),"Favorite list has been fetched",data);
    }
}
