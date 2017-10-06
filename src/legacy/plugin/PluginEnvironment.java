package legacy.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PluginEnvironment {

	private static ScriptEngineManager manager;
	private static ScriptEngine engine;

	public PluginEnvironment() {
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("nashorn");
	}
	
	public Object eval(String _statement) {
		try {
			return engine.eval(_statement);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object eval(File _file) {
		try {
			return engine.eval(new FileReader(_file));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
}
