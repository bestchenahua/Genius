package cqdz.com.genius.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cqdz.com.genius.customer.CornerTransform;


public class ImageLoader {
    public static void load(Context mContext,ImageView bg,String url,RequestOptions options)
    {
        Glide.with(mContext)
                .load(url)
                .apply(options)
                .into(bg);
    }
    public static void load(Context mContext, ImageView bg, Uri imageUri, float  cornerDpValue)
    {
        CornerTransform transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,cornerDpValue));
        transform.setExceptCorner(false,false,false,false);
        RequestOptions options=new RequestOptions().optionalTransform(transform);
        Glide.with(mContext)
                .load(imageUri)
                .apply(options)
                .into(bg);
    }
    public static void load(Context mContext, ImageView bg, Uri imageUri)
    {
        Glide.with(mContext)
                .load(imageUri)
                .into(bg);
    }
    public static void load(Context mContext,ImageView bg,String url,float  cornerDpValue)
    {
        CornerTransform transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,cornerDpValue));
        transform.setExceptCorner(false,false,false,false);
        RequestOptions options=new RequestOptions().optionalTransform(transform);
        Glide.with(mContext)
                .load(url)
                .apply(options)
                .into(bg);
    }
    public static void load(Context mContext,ImageView bg,Integer resourceId,float  cornerDpValue)
    {
        CornerTransform transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,cornerDpValue));
        transform.setExceptCorner(false,false,false,false);
        RequestOptions options=new RequestOptions().optionalTransform(transform);
        Glide.with(mContext)
                .load(resourceId)
                .apply(options)
                .into(bg);
    }
    public static void load(Context mContext,ImageView bg,Integer resourceId  )
    {
        Glide.with(mContext)
                .load(resourceId)
                .into(bg);
    }
    public static void load(Context mContext,ImageView bg,String url)
    {
        Glide.with(mContext)
                .load(url)
                .into(bg);
    }
    public static void load(Context mContext,ImageView bg,Integer resourceId,RequestOptions options)
    {
        Glide.with(mContext)
                .load(resourceId)
                .apply(options)
                .into(bg);
    }
}
