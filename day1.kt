import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("day1input").inputStream()
    val map: MutableMap<Int, Int> = mutableMapOf()
    var frequency = 0
    var found = false
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines{lines -> lines.forEach{ lineList.add(it) }}
    var count = 0;
    while(!found){
        count++
        for(line in lineList){
            if(line.startsWith("+")){
                frequency += line.substring(1).toInt()
            }else{
                frequency -= line.substring(1).toInt()
            }
            if(map[frequency] != null) {
                found = true
                break
            }else{
                map[frequency] = 1
            }
        }
    }
    println("frequency is: $frequency and it took $count laps")
}

