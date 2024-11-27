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
        parameter.size = 60;  // 设置字体大小
        parameter.characters = "设置,音乐大小，音效大小";
        // 3. 生成字体并创建 BitmapFont
        chineseFont = generator.generateFont(parameter);

        // 4. 关闭生成器以释放资源
        generator.dispose();
    }

    public BitmapFont getChineseFont() {
        return chineseFont;
    }
}
