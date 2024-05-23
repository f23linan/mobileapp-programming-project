
# Rapport
Det första som gjordes var att lägga till en recycler view. Sedan behövdes en Dogs class göras och skrivas in data i den, mountain klassen gjordes sedan till en array. En recycleviewadapter klass har också skapats för att kunna skriva ut information om hundarna. Sedan användes Gson för att kunna parsa ut Json data som hundraserna låg i.
Dock behövdes JSON_FILE användas eftersom att JSON_URL inte ville öppna något.

```
<androidx.recyclerview.widget.RecyclerView
android:id="@+id/recycler_view"
android:layout_width="match_parent"
android:layout_height="match_parent"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintLeft_toLeftOf="parent"
app:layout_constraintRight_toRightOf="parent"
app:layout_constraintTop_toTopOf="parent" />
```

```
public class Dogs {

    public String ID;
    @SerializedName("name")
    public String name;


    @SerializedName("location")
    public String location;

    @SerializedName("size")

    public String size;
    @SerializedName("cost")

    public String cost;
    public Dogs() {
        name = "Breed name:";
        location = "Originated:";
        size = "Aprox weight:";
        cost = "Aprox cost:";
    }

    public Dogs(String name) {
        this.name = name;
        this.cost = cost;
        this.location = location;
        this.size = size;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + name + ", Location: " + location + ", Size: " + size + ", Cost: " + cost;
    }

```
```
RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, Breeds, new RecyclerViewAdapter.OnClickListener() {
@Override
public void onClick(Dogs item) {
Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
}
});
```
```
Gson gson = new Gson();
Type type = new TypeToken<List<Mountain>>() {
}.getType();
Breeds = gson.fromJson(json, type);
```

Sedan lades en knapp till på första sidan som kommer att leda till about sidan. 
```
<Button
android:id="@+id/knapp1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="About us"
android:background="@color/colorPrimary"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintHorizontal_bias="0.498"
app:layout_constraintLeft_toLeftOf="parent"
app:layout_constraintRight_toRightOf="parent"
app:layout_constraintTop_toBottomOf="@id/text"
app:layout_constraintVertical_bias="0.17" />
```
```
Button b = findViewById(R.id.knapp1);

        b.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Log.d("==>","Lets go!");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
```


Bilder läggs i samma mapp som markdown-filen.

![](FirstPage.png)
![](SecondPage.png)

