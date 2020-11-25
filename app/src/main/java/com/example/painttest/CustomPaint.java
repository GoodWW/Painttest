package com.example.painttest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 作者：张人文
 * 时间：2020/11/25 09:27
 * 邮箱：479696877@QQ.COM
 * 描述：
 */
class CustomPaint extends View {
    public CustomPaint(Context context) {
        this(context, null);
    }

    public CustomPaint(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomPaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private Paint paint;
    private Context context;
    private Shader shader;
    private Bitmap bitmap;

    private void init() {
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic);

        paint = new Paint();//初始化
//        paint.setColor(context.getResources().getColor(R.color.colorAccent));//设置颜色
//        paint.setARGB(255, 255, 255, 0);//设置paint对象的颜色  范围 0-255
//        paint.setAlpha(200);//设置paint的不透明度 范围 0-255
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setStyle(Paint.Style.FILL);//设置描边效果  FILL 填充内部    STROKE 只有边线  FILL_AND_STROKE 同时作用
//        paint.setStrokeWidth(4);//设置描边宽度  就是上面  STROKE 状态的宽度
//        paint.setStrokeCap(Paint.Cap.BUTT);//设置圆角效果    BUTT  默认情况     ROUND   圆角效果     SQUARE   方角效果
//        paint.setStrokeJoin(Paint.Join.BEVEL);//设置拐角风格    MITER  默认情况  两条线相连有个尖尖角
//        //   BEVEL   会将尖尖角切除    ROUND   平滑的圆角效果
//        paint.setShader(new SweepGradient(200, 200,
//                context.getResources().getColor(R.color.red),
//                getResources().getColor(R.color.yellow)));//设置画笔的渲染器  这是环形渲染器

//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));//设置图层混合模式
//        // DARKEN 让效果进行变暗操作 通过透明度以及颜色的计算最终达到一个计算之后的效果
//
//        paint.setColorFilter(new LightingColorFilter(0x00ffff, 0x000000));//设置颜色过滤器  这里是模仿光照的效果
//        paint.setFilterBitmap(true);//设置双线性过滤  设置之后会让图片的国度效果变得更加平滑

//        paint.setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.NORMAL));//设置画笔的遮罩滤镜  传入度数和样式
//        //NORMAL  在原始边框的内部和外部模糊。
//        // SOLID  在边框内部绘制实线，在外部模糊。
//        // OUTER  在边框内画任何东西，在边框外画模糊。
//        // INNER  边界内模糊，外部不画任何东西。

//        paint.setTextScaleX(2);//对文本进行缩放  1表示不缩放 默认值
//        paint.setTextSize(38);//设置字体大小
//        paint.setTextAlign(Paint.Align.LEFT);//设置文本的对齐方式
//        paint.setUnderlineText(true);//设置下划线

//        String str = "android高级工程师";
//        Rect rect = new Rect();
//        paint.getTextBounds(str,0,str.length(),rect);//测量文本大小  将文本信息存放到rect中
//        float width = paint.measureText(str);//获取文本宽
//        Paint.FontMetrics fontMetrics = paint.getFontMetrics();//获取字体度量对象


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        shader = new LinearGradient(0, 0, 500, 500,
//                new int[]{Color.RED, Color.BLUE,Color.YELLOW},
//               null, Shader.TileMode.CLAMP);//线性渲染器
        // new float[]{0,0.5f,1}
//        paint.setShader(shader);
//        canvas.drawCircle(250,250,250,paint);
//        canvas.drawRect(0,0,500,500,paint);


//        shader = new RadialGradient(250, 250, 250,
//                new int[]{Color.GREEN, Color.YELLOW, Color.RED},
//                null, Shader.TileMode.CLAMP);//环形渲染器  我感觉叫圆形渲染器
//        paint.setShader(shader);
//        canvas.drawCircle(250, 250, 250, paint);




//        shader = new SweepGradient(250, 250,new int[]{ Color.RED, Color.GREEN,Color.RED},null);//扫描渲染
//        paint.setShader(shader);
//        canvas.drawCircle(250,250,250,paint);




//        shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);//位图渲染
//        paint.setShader(shader);
        //Shader.TileMode
        // CLAMP   绘制区域超出渲染区域 以最后一个像素进行填充
        // REPEAT  绘制区域超出渲染区域 平铺效果（重复排版）
        // MIRROR  绘制区域超出渲染区域 镜像
//        canvas.drawCircle(250, 250, 250, paint);
//        canvas.drawRect(0,0,1500,1500,paint);



        //组合渲染
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);//位图渲染
        LinearGradient linearGradient = new LinearGradient(0, 0, 500, 500,
                new int[]{Color.RED, Color.BLUE,Color.YELLOW},
                null, Shader.TileMode.MIRROR);//线性渲染器
        shader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.SCREEN);
        paint.setShader(shader);
        canvas.drawRect(0,0,1500,1500,paint);


        //PorterDuff.Mode 的样式有很多种




    }
}
