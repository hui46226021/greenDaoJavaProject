import com.cn.speedchat.greendao.CoolCat;
import de.greenrobot.daogenerator.*;

import java.io.IOException;

public class Main {

    /**
     * 1.总之main函数就执行了下面几个函数
     * 2.Schema()参数3是数据库版本号，“com.cn.speedchat.greendao”是包名，
     *   也就是说生成的Dao文件会在这个包下，可以将Schema理解为数据库上下文吧
     * 3.addNote() addSession() addReplay()这三个函数相当于建立了三个表，
     *   表名你都可以不用管了会自动生成
     * 4.new DaoGenerator().generateAll()这个是生成Dao文件的路径的位置，
     *   生成在src-gen文件夹里面，跟src同一级目录，所以你自己要在src同一级目录下新建一个src-gen文件夹待会要生成的文件
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        Schema schema = new Schema(3, "com.cn.speedchat.greendao");

        CoolCat.addCommentsBean(schema);


        new DaoGenerator().generateAll(schema, "src-gen");
    }

    /**
     * "MqttChatEntity"相当于是表的类名，用MqttChatEntity生成对象就可以访问这个表属性了，
     * 也就是这个表对应了这个类，待会使用你就会明白了,note.addStringProperty("sessionid").notNull()，
     * 相当于给表里面加一个名字为sessionid的字段，而且不能为空
     * @param schema
     */









}