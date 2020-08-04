package team1.resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author bayug
 */
public class ConfigApp {
    private String storeName;
    private String storeAddress;
    private String since;
    private String dbHost;
    private String dbUname;
    private String dbPass;
    private String dbName;
    private String unameAkun;
    private String nameAkun;
    private String levelAkun;
    private String jkAkun;

    public ConfigApp(){
        readConfig();
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public String getDbUname() {
        return dbUname;
    }

    public void setDbUname(String dbUname) {
        this.dbUname = dbUname;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUnameAkun() {
        return unameAkun;
    }

    public void setUnameAkun(String unameAkun) {
        this.unameAkun = unameAkun;
    }

    public String getNameAkun() {
        return nameAkun;
    }

    public void setNameAkun(String nameAkun) {
        this.nameAkun = nameAkun;
    }

    public String getLevelAkun() {
        return levelAkun;
    }

    public void setLevelAkun(String levelAkun) {
        this.levelAkun = levelAkun;
    }

    public String getJkAkun() {
        return jkAkun;
    }

    public void setJkAkun(String jkAkun) {
        this.jkAkun = jkAkun;
    }
    
    public void readConfig(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/team1/resources/config.json")){
//        try (FileReader reader = new FileReader("C:\\Users\\bayug\\Documents\\"
//                + "NetBeansProjects\\Shoes Cash\\src\\team1\\resources\\config.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray configList = (JSONArray) obj;
            configList.forEach( conf -> parseConfigObject((JSONObject) conf ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void parseConfigObject(JSONObject config){
        JSONObject configObject = (JSONObject) config.get("config");
        JSONObject appConfObject = (JSONObject) configObject.get("appConfig");
        storeName=(String) configObject.get("storeName");
        storeAddress=(String) configObject.get("storeAddress");
        since=(String) configObject.get("since");
        dbHost=(String) appConfObject.get("dbHost");
        dbUname=(String) appConfObject.get("dbUname");
        dbPass=(String) appConfObject.get("dbPass");
        dbName=(String) appConfObject.get("dbName");
        unameAkun=(String) configObject.get("unameAkun");
        nameAkun=(String) configObject.get("nameAkun");
        levelAkun=(String) configObject.get("levelAkun");
        jkAkun=(String) configObject.get("jkAkun");
    }    
    
    public void writeConfig(){
        JSONObject appConf = new JSONObject();
        appConf.put("dbHost", (dbHost == null?"kosong":dbHost));
        appConf.put("dbUname", (dbUname == null?"kosong":dbUname));
        appConf.put("dbPass", (dbPass == null?"kosong":dbPass));
        appConf.put("dbName", (dbName == null?"kosong":dbName));
        JSONObject confDetail = new JSONObject();
        confDetail.put("appConfig", appConf);
        confDetail.put("storeName", (storeName == null?"kosong":storeName));
        confDetail.put("storeAddress", (storeAddress == null?"kosong":storeAddress));
        confDetail.put("since", (since == null?"kosong":since));
        confDetail.put("unameAkun", (unameAkun == null?" ":unameAkun));
        confDetail.put("nameAkun", (nameAkun == null?" ":nameAkun));
        confDetail.put("levelAkun", (levelAkun == null?" ":levelAkun));
        confDetail.put("jkAkun", (jkAkun == null?" ":jkAkun));
        JSONObject confObject = new JSONObject(); 
        confObject.put("config", confDetail);
        JSONArray confList = new JSONArray();
        confList.add(confObject);
        try (FileWriter file = new FileWriter("src/team1/resources/config.json")) {
            file.write(confList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void defauldMe(){
        dbHost="localhost";
        dbName="db_shoescash";
        dbUname="root";
        dbPass="";
        storeName="Toko Boba";
        storeAddress="Jln. Tan Malaka, Km.12 ";
        since="2020";
        unameAkun=" ";
        nameAkun=" ";
        levelAkun=" ";
        jkAkun=" ";
    }
    
//    public static void main(String[] args) throws IOException {
//        ConfigApp c = new ConfigApp();
//        c.defauldMe();
//        c.writeConfig();
//    }
}
