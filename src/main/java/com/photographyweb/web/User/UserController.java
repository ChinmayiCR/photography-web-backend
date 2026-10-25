package com.photographyweb.web.User;

import org.springframework.web.bind.annotation.*;
import com.photographyweb.web.pojo.Image;
import com.photographyweb.web.pojo.Order;
import com.photographyweb.web.pojo.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final String IMAGE_CONTENT = "Homemade spices with selected ingredients in right proportions.";

    @GetMapping("/images")
    public List<Image> getAllImages(){
        return List.of(
                new Image(
                        "image1",
                        "Pulav Powder",
                        IMAGE_CONTENT,
                        "image1",
                        "main >> image1",
                        125,
                        100
                ),
                new Image(
                        "image2",
                        "Rasam powder",
                        IMAGE_CONTENT,
                        "image2",
                        "main/image2",
                        180,
                        250
                ),
                new Image(
                        "image3",
                        "Groundnut Chutney Powder",
                        IMAGE_CONTENT,
                        "image3",
                        "main/image3",
                        500,
                        0
                ),
                new Image(
                        "image4",
                        "Midi Pickle",
                        IMAGE_CONTENT,
                        "image4",
                        "main/image4",
                        250,
                        0
                ),
                new Image(
                        "image5",
                        "Curry Leaves Chutney Pudi",
                        IMAGE_CONTENT,
                        "image5",
                        "main/image5",
                        250,
                        0
                ),
                new Image(
                        "image6",
                        "Engayi Powder",
                        IMAGE_CONTENT,
                        "image6",
                        "main/image6",
                        500,
                        0
                ),
                new Image(
                        "image7",
                        "Lemon Pickle",
                        IMAGE_CONTENT,
                        "image7",
                        "main/image7",
                        250,
                        0
                ),
                new Image(
                        "image8",
                        "Honey",
                        IMAGE_CONTENT,
                        "image8",
                        "main/image8",
                        250,
                        0
                ),
                new Image(
                        "image9",
                        "Turmeric Powder",
                        IMAGE_CONTENT,
                        "image9",
                        "main/image9",
                        500,
                        0
                ),
                new Image(
                        "image10",
                        "Sambar Powder",
                        IMAGE_CONTENT,
                        "image10",
                        "main/image10",
                        500,
                        0
                ),
                new Image(
                        "image11",
                        "Pepper",
                        IMAGE_CONTENT,
                        "image11",
                        "main/image11",
                        500,
                        0
                ),
                new Image(
                        "image12",
                        "Vangibath Powder",
                        IMAGE_CONTENT,
                        "image12",
                        "main/image12",
                        500,
                        0
                ),
                new Image(
                        "image13",
                        "Puliyogre Paste",
                        IMAGE_CONTENT,
                        "image13",
                        "main/image13",
                        500,
                        0
                )
        );
    }

    @GetMapping("/images/{imageId}")
    public String getImageById(@PathVariable String imageId){
        return "Successful";
    }

    @GetMapping("/item/{imageid}")
    public String getItemByImageId(@PathVariable String imageid){
        return "Successful";
    }

    @GetMapping("/order")
    public Order getOrder(){
        return new Order("1", "Sample Photo", "100");
    }

    @PostMapping("/contactus")
    public void postContactus(@RequestBody User user){
        return;
    }
}
