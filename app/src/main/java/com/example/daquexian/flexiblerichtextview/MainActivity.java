package com.example.daquexian.flexiblerichtextview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.daquexian.flexiblerichtextview.Attachment;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Attachment> attachments = new ArrayList<>();
        attachments.add(new ExampleAttachment("Android Image", "53ce1", true, "http://tse1.mm.bing.net/th?id=OIP.M24baa78c1fb80a71891ce775d11e038ao0&w=166&h=166&c=7&qlt=90&o=4&pid=1.7"));
        attachments.add(new ExampleAttachment("Here is a link", "bc41a", false, "https://google.com"));

        FlexibleRichTextView flexibleRichTextView = (FlexibleRichTextView) findViewById(R.id.frtv);
        flexibleRichTextView.setOnClickListener(new FlexibleRichTextView.OnViewClickListener() {
            @Override
            public void onImgClick(ImageView imageView) {
                Toast.makeText(MainActivity.this, imageView.getTag().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAttClick(Attachment attachment) {

            }

            @Override
            public void onQuoteButtonClick(View view, boolean collapsed) {

            }

            @Override
            public void onMxButtonClick(View view) {

            }
        });

        String originalStr =
                "[B]text[/B] [i]text[/i]  [u]text[/u]  [s]text[/s]  [color=#FF0000]Red[/color] [color=red]Red2[/color]  " +
                        "[size=15] Entry 2 size test [/size] \n" +
                        "[url=http://example.com]Example[/url]\n" +
                        "[url]http://example.com[/url]\n" +
                        "[img]https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Laser_Towards_Milky_Ways_Centre.jpg/660px-Laser_Towards_Milky_Ways_Centre.jpg[/img]\n" +
                        "[quote=auther]quoted text[/quote]" +
                        "[img width=50 height=10]http://attach.bbs.miui.com/forum/201402/21/120043wsfuzzuefyasz3fe.jpg[/img]\n" +
                        "[img]https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Gnome-emblem-web.svg/50px-Gnome-emblem-web.svg.png[/img]\n" +
                        "[list] [*]Entry 1 [*]Entry 2 [/list]0000" +
                        "[list] [*]Entry 3 [*]Entry 4 [/list]" +
                        "[list] *Entry 5 *Entry 6 [/list]" +
                        "[ol][li]Item 11[/il][li]Item 12[/il][/ol]" +
                        "[ul][li]Item 21[/il][li]Item 22[/il][/ul]" +
                        "[list][li]Item 31[/il][li]Item 32[/il][/list]" +
                        "[code]String TAG = \"tag\"[/code]\n" +
                        "[center]This is some centered text[/center]" +
                        "";

        String originalStr2 =
                "[list] [*]Entry 1 [*]Entry 2 [/list]" +
                        "<h><center>[color=red]hi![/color]</center></h>" +
                        "[quote]This is quote\n" +
                        "second line\n" +
                        "third line\n" +
                        "fourth line[/quote]" +
                        "[img]http://tse1.mm.bing.net/th?id=OIP.M24baa78c1fb80a71891ce775d11e038ao0&w=166&h=166&c=7&qlt=90&o=4&pid=1.7[/img]" +
                        "Here is an attachment:[attachment:53ce1]" +
                        "[code]print(\"Hello FlexibleRichTextView!\")[/code]" +
                        "Hello FlexibleRichTextView!\n" +
                        "This is LaTeX:\n" +
                        "$e^{\\pi i} + 1 = 0$\n" +
                        "This is table:\n" +
                        "| First Header  | Second Header |\n" +
                        "| --- | --- |\n" +
                        "| Content [code]print(\"Hello!\")[/code]  | Content Cell  |\n" +
                        "| Content [color=red]hi![/color]  | Content [img]http://tse1.mm.bing.net/th?id=OIP.M24baa78c1fb80a71891ce775d11e038ao0&w=166&h=166&c=7&qlt=90&o=4&pid=1.7[/img]  |\n" +
                        "An attachment is shown at the bottom: \n";


        String originalStr3 =
//                "ABCD" +
                "[img=250x160]http://i60.tinypic.com/1607k6.png[/img]\n" +
                        "[img width=250 height=160]http://i60.tinypic.com/1607k6.png[/img]\n" +
                        "[url=http://www.baidu.com][img]http://i60.tinypic.com/1607k6.png[/img][/url]\n" +
                        "[url=http://support.prophpbb.com][img=250x160]http://i60.tinypic.com/1607k6.png[/img][/url]\n" +
                        "";

        String originalStr4 = "[youtube]bUYidQDvYJA[/youtube]" +
                "[mxButton=bot_account_link]I am button[/mxButton]" +
                "[mxButton=callback payload=\"the-payload\"]I am button[/mxButton]" +
                "[mxButton=bot_postback payload=\"the-payload\"]I am button[/mxButton]" +
                "";

        String originalStr5 = "This is table:\n" +
                "[table]" +
                "[th][td]First Header[/td][td]Second Header[/td][/th]" +
                "[tr][td]AAA[/td][td]BB[/td][/tr]" +
                "[tr][td][mxButton=bot_account_link]I am button[/mxButton][/td][td]dd[/td][/tr]" +
                "[/table]";
        String originalStr6 =
                "[B]text[/B][B]text22[/B]" +
                        "[size=45] Entry 2 size test [/size] \n" +
                        "[code]String TAG = \"tag\"; \n int a = 100 * 90;[/code]\n" +
                        "[center]This is some centered text[/center]\n" +
                        "[left]This is some left text[/left]\n" +
                        "[right]This is some right text[/right]\n" +
                        "[list][li]Item 21[/li][li]Item 22[/li][li]Item 23[/li][/list]" +
                "[list][li]AAA[/li][li]BB[/li][/list]" +
                        "[i]text[/i]  [u]text[/u]  [s]text[/s]  [color=#FF0000]Red[/color] [color=red]Red2[/color]  " +
                        "";
        flexibleRichTextView.setText(originalStr + originalStr2 + originalStr3 + originalStr4 + originalStr5 + originalStr6,
                null);

/*
        mList = (ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter();
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            datas.add(originalStr);
        }
        adapter.setData(datas);
        mList.setAdapter(adapter);*/

    }
}