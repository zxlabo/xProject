package com.example.myapplication;

import android.graphics.Color;
import android.widget.Button;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class MainLithoViewSpec {

    @OnCreateLayout
    public static Component onCreateLayout(ComponentContext context, @Prop int color, @Prop String title) {
        return Column.create(context)
                .paddingDip(YogaEdge.ALL, 16f)
                .backgroundColor(Color.DKGRAY)
                .child(
                        Text.create(context).text(title)
                                .textColor(color)
                                .textSizeDip(25f)
                )
                .child(
                        Text.create(context).text("这是小标题")
                                .textColor(Color.GREEN)
                                .textSizeDip(16f)
                )
                .build();
    }
}
