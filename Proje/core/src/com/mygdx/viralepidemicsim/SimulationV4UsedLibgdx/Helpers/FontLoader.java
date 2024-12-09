package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class FontLoader {
    private BitmapFont chineseFont;

    public FontLoader() {
        // 1. 创建 FreeTypeFontGenerator，指定字体文件路径
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("MoonStarsKaiHW-Bold.ttf"));

        // 2. 创建字体参数
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 45;  // 设置字体大小
        parameter.characters = "设置,音乐大小，音效大小,开始模拟,使用帮助,关于我们,退出到桌面,呼吸道疾病模拟器,密接，感染人数:,1,2,3,4,5,6,7,8,9,0" +
        "制作团队,阿哈迈德·法伊克·乌特库,阿哈迈德·塔里克·乌库尔,图纳·朱玛,埃姆雷·阿克居尔,古恩·塔斯坦,刘沛泽,王道冲,王顺意"+
        "免疫,死亡,天,周一二三四五六日,指定日期范围,初始感染者数量,死亡率,疫苗接种率,选择已知病毒,传播率,狂犬病毒,年龄在65岁以上的-,关闭学校,工作场所";

        // 3. 生成字体并创建 BitmapFont
        chineseFont = generator.generateFont(parameter);

        // 4. 关闭生成器以释放资源
        generator.dispose();
    }

    public BitmapFont getChineseFont() {
        return chineseFont;
    }
}
