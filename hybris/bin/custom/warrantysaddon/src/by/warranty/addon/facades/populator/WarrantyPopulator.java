package by.warranty.addon.facades.populator;

import by.warranty.addon.facades.product.data.WarrantyData;
import by.warranty.addon.model.WarrantyModel;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class WarrantyPopulator implements Populator<WarrantyModel, WarrantyData>
{

    private Converter<MediaContainerModel, List<ImageData>> mediaContainerConverter;

    @Override
    public void populate(WarrantyModel source, WarrantyData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setDescription(source.getDescription());
        target.setLength(source.getLength());
        target.setName(source.getName());
        target.setWarrantyText(source.getWarrantyText());
        target.setWarrantyTextPDF(mediaContainerConverter.convert(source.getWarrantyTextPDF()));
        target.setWarrantyType(source.getWarrantyType().getCode());
    }

    @Required
    public void setMediaContainerConverter(final Converter<MediaContainerModel, List<ImageData>> mediaContainerConverter)
    {
        this.mediaContainerConverter = mediaContainerConverter;
    }
}
