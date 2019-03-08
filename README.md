# ImageDotSlider
An android library for making simple image slider carousels

##### Features
- Listeners for Page Scrolling
- Listeners for Page Scoll State Changes
- Listeners for Clicking on Page
- Quick implementation


## How to use
###### Add the following to your app build.gradle file
```kotlin
implementation 'com.duplex.imagedotslider:imagedotslider:1.0.2'
```

###### Add this view to your layout file
```xml
<com.mmurphy.imagedotslider.ImageSliderView
        android:id="@+id/image_slider"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        app:imageResources="@array/image_id_array" />
```
NOTE: Make sure you set your imageResources to the name of your image array!

###### Create this image array in your strings.xml file
```xml
<integer-array name="image_id_array">
    <item>@drawable/image1</item>
    <item>@drawable/image2</item>
    <item>@drawable/image3</item>
    <item>@drawable/image4</item>
    <item>@drawable/image5</item>
</integer-array>
```

###### To add listeners to the image slider object, extend ViewPager.OnPageChangeListener and set the image slider's OnPageListener to this. Then simply implement the required functions.
```kotlin
/****** 1.) Extend ViewPager.OnPageChangeListener so we can listen for scrolls and clicks ******/
class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /****** 2.) Set the listener for the image slider ******/
        image_slider.addOnPageChangeListener(this)
    }
                                            
    /****** 3.) Override the required functions ******/
    // Listener for Scrolling State Changes
    override fun onPageScrollStateChanged(state: Int) {
        Log.d("OnPageScrollStateChange", "$state")
    }

    // Listener for Page Scrolling 
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("OnPageScrolled", "$position")
    }

    // Listener for Page Clicks
    override fun onPageSelected(position: Int) {
        Log.d("OnPageSelected", "$position")
    }
}
```
