package blog.jinhyun.simpleweatherandroid.core.common.datetime.serializer

import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NetworkDateSerializer : KSerializer<NetworkDate> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("NetworkDate", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): NetworkDate =
        NetworkDate.parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: NetworkDate) {
        encoder.encodeString(value.toString())
    }
}