/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities;

/**
 * Receive required generic items.
 *
 * @param <T> generics elements.
 */
public class RequisiteElement<T> {

    private T element;
    private String id;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
