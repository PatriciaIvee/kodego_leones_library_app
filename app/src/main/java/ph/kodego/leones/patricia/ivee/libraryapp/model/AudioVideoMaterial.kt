package ph.kodego.leones.patricia.ivee.libraryapp.model

class AudioVideoMaterial(title: String):Publication(title)  {
//    (var magazineTitle:String = "Unknown", var magazinePublisher: String = "Unknown", var img: Int)

    var audioVideoMaterialId: Int = 0
    var publisherId: Int = 0
    var category :String = AudioVideoMaterialCategory.UNSPECIFIED.toString()

}
enum class AudioVideoMaterialCategory {
    UNSPECIFIED,
    RECORDING,
    MOVIE,
    PRESENTATION,
    DOCUMENTARY,
    EQUIPMENT
}