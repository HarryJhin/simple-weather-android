package blog.jinhyun.simpleweatherandroid.core.common.datetime.serializer

import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NetworkTimeSerializer : KSerializer<NetworkTime> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("NetworkTime", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): NetworkTime =
        NetworkTime.parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: NetworkTime) {
        encoder.encodeString(value.toString())
    }
}