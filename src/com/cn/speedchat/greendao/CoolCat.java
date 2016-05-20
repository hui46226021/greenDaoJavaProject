package com.cn.speedchat.greendao;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Created by zhush on 2016/5/20.
 */
public class CoolCat {
    public static void addCommentsBean(Schema schema)
    {
        Entity customer = schema.addEntity("GifitemBean");
        customer.addIdProperty().primaryKey();
        customer.addLongProperty("NETid").notNull();
        customer.addStringProperty("content").notNull();
        customer.addStringProperty("category_name").notNull();
        customer.addStringProperty("firstOne").notNull();
        customer.addStringProperty("gifUrl");
        customer.addIntProperty("width").notNull();
        customer.addIntProperty("height").notNull();
        customer.addIntProperty("type").notNull();
        customer.addIntProperty("digg_count").notNull();
        customer.addIntProperty("bury_count").notNull();
        customer.addIntProperty("comments_count").notNull();
        customer.addStringProperty("share_url").notNull();

        //图片集合
        Entity pictureBean = schema.addEntity("PictureBean");
        pictureBean.setTableName("PICTUREBEAN"); // 给表重新命名
        pictureBean.addIdProperty();
        pictureBean.addStringProperty("largeImage").notNull();
        pictureBean.addStringProperty("thumbImage").notNull();
        Property large_image_listId = pictureBean.addLongProperty("large_image_listId").notNull().getProperty();
//        order.addToOne(customer, customerId);
        ToMany customerToOrders = customer.addToMany(pictureBean, large_image_listId);
        customerToOrders.setName("large_image_list");


        //评论
        Entity commentsBean = schema.addEntity("CommentsBean");
        commentsBean.setTableName("COMMENTSBEAN"); // 给表重新命名
        commentsBean.addIdProperty().primaryKey();
        commentsBean.addLongProperty("NETid").notNull();
        commentsBean.addStringProperty("commentUserName").notNull();
        commentsBean.addStringProperty("commentUserProfile").notNull();
        commentsBean.addStringProperty("comment").notNull();
//        Property commentsBeanId = customer.addLongProperty("commentsBeanId").getProperty();
//        ToOne toOne1 = customer.addToOne(commentsBean, commentsBeanId);
//        toOne1.setName("comments");


        //发布人
        Entity releaseUser = schema.addEntity("ReleaseUser");
        releaseUser.setTableName("RELEASEUSER"); // 给表重新命名
        releaseUser.addIdProperty().primaryKey();
        releaseUser.addLongProperty("NETid").notNull();
        releaseUser.addStringProperty("username").notNull();
        releaseUser.addStringProperty("userProfile").notNull();
//        Property releaseUserId = customer.addLongProperty("releaseUserId").getProperty();
//        ToOne toOne2= customer.addToOne(releaseUser, releaseUserId);
//        toOne2.setName("releaseUser");



        Entity customer2 = schema.addEntity("DuanZiBean");
        customer2.addIdProperty();
        customer2.addLongProperty("NETid").notNull();
        customer2.addStringProperty("content").notNull();
        customer2.addStringProperty("category_name").notNull();
        customer2.addIntProperty("type").notNull();
        customer2.addIntProperty("digg_count").notNull();
        customer2.addIntProperty("bury_count").notNull();
        customer2.addIntProperty("comments_count").notNull();
        customer2.addStringProperty("share_url").notNull();
//        Property commentsBeanId2 = customer2.addLongProperty("commentsBeanId").getProperty();
//        ToOne toOne3= customer2.addToOne(releaseUser, commentsBeanId2);
//        toOne3.setName("releaseUser");
//        Property releaseUserId2 = customer2.addLongProperty("releaseUserId").getProperty();
//        ToOne toOne14= customer2.addToOne(commentsBean, releaseUserId2);
//        toOne14.setName("comments");
    }
}
