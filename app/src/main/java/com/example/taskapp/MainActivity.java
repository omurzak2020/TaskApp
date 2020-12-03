package com.example.taskapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProfileImage = (CircleImageView) findViewById(R.id.Profile);
        BottomNavigationView navView = findViewById(R.id.nav_view);


         appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_Profile, R.id.btnsave)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.btnsave){
                    navView.setVisibility(View.VISIBLE);

                }
            }
        });
//        ProfileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gallery =new Intent();
//                gallery.setType("image/*");
//                gallery.setAction(Intent.ACTION_GET_CONTENT);
//
//                startActivity(Intent.createChooser(gallery,"Sellect Picture"),PICK_IMAGE);
//
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && requestCode == RESULT_OK){
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                ProfileImage.setImageBitmap(bitmap);

            }catch (IOException c){
                c.printStackTrace();

            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }
    public void closeFragment(){
        navController.navigateUp();
    }
}