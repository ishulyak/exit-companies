package com.uawar.exit.mapper;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

/**
 * Base mapper to convert Dto to ENTITY and vise versa.
 *
 * @param <RequestDto>  The given request Dto type;
 * @param <ResponseDto> The given response Dto type;
 * @param <Entity>      The given Entity type.
 */
public interface BaseMapper<RequestDto, ResponseDto, Entity> {
    /**
     * Convert {@link Entity} to {@link ResponseDto}.
     *
     * @param entity The given {@link Entity} instance;
     * @return Returns the converted {@link ResponseDto} instance.
     */
    ResponseDto toDto(Entity entity);

    /**
     * Convert a list of {@link Entity} instances to a list of {@link ResponseDto} instances.
     *
     * @param entitiesCollection The given collection of {@link Entity} instances;
     * @return Returns a list of {@link ResponseDto} instances.
     */
    List<ResponseDto> toDto(Collection<Entity> entitiesCollection);

    /**
     * Convert {@link RequestDto} to {@link Entity}.
     *
     * @param dto The given {@link RequestDto} value;
     * @return Returns the converted {@link Entity} instance.
     */
    Entity toEntity(RequestDto dto);

    /**
     * Convert {@link RequestDto} to {@link Entity} including Id.
     *
     * @param dto The given {@link RequestDto} value;
     * @param id  The given Id of ENTITY;
     * @return Returns the converted {@link Entity} instance.
     */
    Entity toEntity(RequestDto dto, String id);

    /**
     * Convert a list of {@link RequestDto} instances to a list of {@link Entity} instances.
     *
     * @param dtosCollection The given collection of {@link RequestDto} values;
     * @return Returns a list of {@link Entity} instances.
     */
    List<Entity> toEntity(Collection<RequestDto> dtosCollection);

    /**
     * Create new {@link Entity} from {@link Entity}.
     *
     * @param entity The given {@link Entity} value;
     * @return Returns new {@link Entity} instance.
     */
    Entity clone(Entity entity);

    /**
     * Create list of new {@link Entity} from list of {@link Entity}.
     *
     * @param entity The given list of {@link Entity};
     * @return Returns new list of {@link Entity}.
     */
    List<Entity> clone(List<Entity> entity);

    default Integer map(String value) {
         try {
             return Integer.parseInt(value);
         } catch (Exception e) {
             return null;
         }
    }

    default String map(Integer value) {
        return value == null ? null : Integer.toString(value);
    }
}

