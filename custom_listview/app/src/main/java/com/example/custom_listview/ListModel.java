package com.example.custom_listview;
public class ListModel
{
    private String CompName = "";
    private String Image = "";
    private String Url = "";
    /*********** Set Methods ******************/
    public void setCompanyName(String CompName)
    {
        this.CompName = CompName;
    }
    public void setImage(String Image)
    {
        this.Image = Image;
    }
    public void setUrl(String Url)
    {
        this.Url = Url;
    }
    /*********** Get Methods ****************/
    public String getCompanyName()
    {
        return this.CompName;
    }
    public String getImage()
    {
        return this.Image;
    }
    public String getUrl()
    {
        return this.Url;
    }
}