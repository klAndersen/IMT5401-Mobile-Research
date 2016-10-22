package guc.imt5401.trackmyteacher;

/**
 * Class that creates an object to store the current WiFi data
 * @author Knut Lucas Andersen
 */
public class WiFiObjectClass {
    private String _wifiName;
    private String _wifiSSID;
    private String _wifiBSID;
    private String _wifiAddress;
    private int _wifiSignalStrength;

    /**
     * Constructor for creating a WiFi object
     * @param wifiName - String: The name of the Wi-Fi the user is connected to
     * @param wifiSSID - String: The Wi-Fis SSID
     * @param wifiBSID - String: The Wi-Fis BSID
     * @param wifiAddress - String: The Wi-Fis address
     * @param wifiSignalStrength - int: The Wi-Fis signal strength
     */
    public WiFiObjectClass(String wifiName, String wifiSSID, String wifiBSID, String wifiAddress, int wifiSignalStrength) {
        this._wifiName = wifiName;
        this._wifiSSID = wifiSSID;
        this._wifiBSID = wifiBSID;
        this._wifiAddress = wifiAddress;
        this._wifiSignalStrength = wifiSignalStrength;
    } //constructor

    /**
     *
     * @return
     */
    public String getWifiName() {
        return _wifiName;
    } //getWifiName

    /**
     *
     * @return
     */
    public String getWifiSSID() {
        return _wifiSSID;
    } //getWifiSSID

    /**
     *
     * @return
     */
    public String getWifiBSID() {
        return _wifiBSID;
    } //getWifiBSID

    /**
     *
     * @return
     */
    public String getWifiAddress() {
        return _wifiAddress;
    } //getWifiAddress

    /**
     *
     * @return
     */
    public int getWifiSignalStrength() {
        return _wifiSignalStrength;
    } //getWifiSignalStrength
} //WiFiObjectClass
