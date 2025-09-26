package com.example.restaurant_service.services.impl;
import com.example.restaurant_service.dto.requestDTOs.RestaurantCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.ProfileCompletion;
import com.example.restaurant_service.dto.responseDTOs.RestaurantResponseDTO;
import com.example.restaurant_service.models.RestaurantModel;
import com.example.restaurant_service.repositories.AddressRepository;
import com.example.restaurant_service.repositories.CategoryRepository;
import com.example.restaurant_service.repositories.MenuRepository;
import com.example.restaurant_service.repositories.RestaurantRepo;
import com.example.restaurant_service.services.AddressService;
import com.example.restaurant_service.services.CategoryService;
import com.example.restaurant_service.services.MenuService;
import com.example.restaurant_service.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class RestaurantService_Impl implements RestaurantService {
    @Autowired
    RestaurantRepo repo;
    @Autowired
    private MenuRepository menuRepo;
    @Autowired
    private AddressRepository addressRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Override
    public RestaurantResponseDTO addRestaurant(RestaurantCreateDTO restaurant){
        RestaurantModel newRestaurant = new RestaurantModel();
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setDescription(restaurant.getDescription());
        newRestaurant.setPhone_number(restaurant.getPhone_number());
        newRestaurant.setOwnerId(UUID.fromString(restaurant.getOwner_id()));
        newRestaurant.setEmail(restaurant.getEmail());
        newRestaurant.setLogo_url(restaurant.getLogo_url());
        newRestaurant.setStatus(restaurant.getStatus());
        newRestaurant.setIsActive(restaurant.getIsActive());
        newRestaurant.setCreated_at(Timestamp.from(Instant.now()));
        newRestaurant.setUpdated_at(Timestamp.from(Instant.now()));
        RestaurantModel createdRestaurant = repo.save(newRestaurant);
        return new RestaurantResponseDTO(createdRestaurant.getId().toString(), createdRestaurant.getName(), createdRestaurant.getDescription(), createdRestaurant.getPhone_number(), createdRestaurant.getEmail(), createdRestaurant.getLogo_url(), createdRestaurant.getStatus(), createdRestaurant.getOwnerId().toString(), createdRestaurant.getIsActive(), Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
    }

    @Override
    public ProfileCompletion getCompletion(String id){
        if(!addressRepo.getByRestaurantId(UUID.fromString(id)).isEmpty()){
            if(!categoryRepo.getByRestaurantId(UUID.fromString(id)).isEmpty()){
                if(!menuRepo.getByRestaurantId(UUID.fromString(id)).isEmpty()){
                    return new ProfileCompletion(100.00, true, true, true);
                }
                else{
                    return new ProfileCompletion(70.00, true, true, false);
                }
            }
            else{
                return new ProfileCompletion(40.00, true, false, false);
            }
        }
        else{
            return new ProfileCompletion(10.0, false, false, false);
        }
    }

//    @Override
//    public RestaurantResponseDTO updateRestaurant(String id, RestaurantCreateDTO restaurant){
//
//    }
//
    @Override
    public RestaurantResponseDTO getRestaurantDetails(String id){
        RestaurantModel restaurant = repo.getReferenceById(UUID.fromString(id));
        return new RestaurantResponseDTO(restaurant.getId().toString(), restaurant.getName(), restaurant.getDescription(), restaurant.getPhone_number(), restaurant.getEmail(), restaurant.getLogo_url(), restaurant.getStatus(), restaurant.getOwnerId().toString(), restaurant.getIsActive(), restaurant.getCreated_at(), restaurant.getUpdated_at());
    }
//
//    @Override
//    public ArrayList<RestaurantResponseDTO> getRestaurants(SearchFilterRequest filter){
//
//    }
}
