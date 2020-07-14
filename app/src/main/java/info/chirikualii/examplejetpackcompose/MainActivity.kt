package info.chirikualii.examplejetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import info.chirikualii.examplejetpackcompose.ui.ExampleJetpackComposeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            composeListPerson(personList = listPerson)
        }
    }
}
@Composable
fun composeListPerson(personList : List<Person>){

    LazyColumnItems(items = personList) {person ->
        val index = personList.indexOf(person)
        Row(modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth()) {

            Card(
                shape = RoundedCornerShape(4.dp),
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = person.name.toString(),
                    style = TextStyle(color = Color.Black,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

        }
    }

}

@Preview
@Composable
fun composeListPersonPreview(){

    composeListPerson(personList = listPerson)

}

data class Person(
        var name :String?=null,
        var age:Int )

val listPerson = listOf<Person>(
    Person("Grace Hopper", 25),
    Person("Ada Lovelace", 29),
    Person("John Smith", 28),
    Person("Elon Musk", 41),
    Person("Will Smith", 31),
    Person("Robert James", 42),
    Person("Anthony Curry", 91),
    Person("Kevin Jackson", 22),
    Person("Robert Curry", 1),
    Person("John Curry", 9),
    Person("Ada Jackson", 2),
    Person("Joe Defoe", 35)
)


