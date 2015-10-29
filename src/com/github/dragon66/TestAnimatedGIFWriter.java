package com.github.dragon66;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class TestAnimatedGIFWriter {

	public static void main(String[] args) throws Exception {
		// args[0] directory for images
		// args[1] regex like .*\.(gif|GIF)$ will grab all GIF images
		File[] files = listFilesMatching(new File(args[0]), args[1]);
		AnimatedGIFWriter writer = new AnimatedGIFWriter(true);
		OutputStream os = new FileOutputStream("animated.gif");
		writer.prepareForWrite(os, -1, -1);
		for(File file : files) {
			FileInputStream fin = new FileInputStream(file);
			BufferedImage image = javax.imageio.ImageIO.read(fin);
			fin.close();
			writer.writeFrame(os, image);
		}
		writer.finishWrite(os);
		os.close();
	}
	
	private static File[] listFilesMatching(File root, String regex) {
	    if(!root.isDirectory()) {
	        throw new IllegalArgumentException(root+" is not a directory.");
	    }
	    final Pattern p = Pattern.compile(regex);
	    return root.listFiles(new FileFilter(){
	        public boolean accept(File file) {
	            return p.matcher(file.getName()).matches();
	        }
	    });
	}
}