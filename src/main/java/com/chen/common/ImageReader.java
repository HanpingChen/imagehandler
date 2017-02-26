package com.chen.common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chen on 17/2/24.
 */
public class ImageReader {
    private int [][] result;
    private int width = 0;
    private int height = 0;
    private int rgb[];
    public ImageReader(String path) {
        // TODO Auto-generated constructor stub
        rgb = new int[3];
        result = readImage(path);
    }

    public int[][] getResult() {
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getRgb() {
        return rgb;
    }

    public void setRgb(int[] rgb) {
        this.rgb = rgb;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setResult(int[][] result) {
        this.result = result;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int[][] readImage(String path) {
        File file = new File(path);
        int result[][] = null;
        try {
            BufferedImage bi = ImageIO.read(file);
            int width = bi.getWidth();
            int height = bi.getHeight();
            setHeight(height);
            setWidth(width);
            result = new int[width][height];
            for(int i=0;i<width;i++){
                for(int j=0;j<height;j++){
                    result[i][j] = bi.getRGB(i, j);

                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public void display() {
        for(int i=0;i<width/3;i++){
            for(int j=0;j<height/3;j++){
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");
            }
        }
    }
}
