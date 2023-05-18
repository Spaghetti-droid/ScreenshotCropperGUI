package fun.gbr.gui.config;

import java.nio.file.Path;

import fun.gbr.gui.ConfigGUI;
import fun.gbr.options.Options;

public class ConfigManager {
	
	private Options options = new Options();
	
	public String getPath() {
		return options.getPath().toString();
	}
	
	public String getXOffset() {
		return String.valueOf(options.getXOffset());
	}
	
	public String getYOffset() {
		return String.valueOf(options.getYOffset());
	}
	
	public String getWidth() {
		return String.valueOf(options.getWidth());
	}
	
	public String getHeight() {
		return String.valueOf(options.getHeight());
	}
	
	public void save(ConfigGUI window) {
		options.setPath(Path.of(window.getPathField().getText()));
		options.setXOffset(Integer.valueOf(window.getxOffsetField().getText()));
		options.setYOffset(Integer.valueOf(window.getyOffsetField().getText()));
		options.setWidth(Integer.valueOf(window.getWidthField().getText()));
		options.setHeight(Integer.valueOf(window.getHeightField().getText()));
		options.save();
	}
}
