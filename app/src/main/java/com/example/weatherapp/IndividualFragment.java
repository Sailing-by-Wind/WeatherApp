package com.example.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndividualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndividualFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int PICK_IMAGE_REQUEST = 1;//获取图片的额请求码为1

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imageView1;
    private ImageView imageView2;

    public IndividualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndividualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndividualFragment newInstance(String param1, String param2) {
        IndividualFragment fragment = new IndividualFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_individual, container, false);
        // 在 Fragment 的 onCreateView 方法中设置背景图片（可能造成卡顿）
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        String backgroundImageBase64 = sharedPreferences.getString("backgroundImageBase64", "");
//
//        Bitmap backgroundImageBitmap = null;
//        if (!backgroundImageBase64.isEmpty()) {
//            byte[] decodedString = Base64.decode(backgroundImageBase64, Base64.DEFAULT);
//            backgroundImageBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        }
//        if (backgroundImageBitmap != null) {
//            Drawable backgroundImageDrawable = new BitmapDrawable(getResources(), backgroundImageBitmap);
//            rootView.setBackground(backgroundImageDrawable);
//        }

        imageView1 = rootView.findViewById(R.id.background_img);
        Button change = rootView.findViewById(R.id.background_change);
        change.setOnClickListener(v -> {
            //选择本地图片
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        });
        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            if (imageUri != null) {
                try {
                    // 将图片设置为 ImageView 的背景
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), imageUri);
//                    //将 Bitmap 转换为 Base64 字符串并保存到 SharedPreferences 中：（长期背景）
//                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//                    String backgroundImageBase64 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
//                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("backgroundImageBase64", backgroundImageBase64);
//                    editor.apply();
                    //Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                    imageView1.setImageBitmap(bitmap);//设置为背景
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 将选择的图片传递给Activity
        //((BeginActivity) getActivity()).setFragmentBackground(data.getData());
    }
}
