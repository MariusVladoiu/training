package com.wipro.training.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wipro.training.configuration.IntegrationTest;
import com.wipro.training.service.PersonDTO;
import com.wipro.training.service.PersonService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService service;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        when(service.getPersonList()).thenReturn(new List<PersonDTO>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<PersonDTO> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(PersonDTO personDTO) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends PersonDTO> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends PersonDTO> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public PersonDTO get(int index) {
                return null;
            }

            @Override
            public PersonDTO set(int index, PersonDTO element) {
                return null;
            }

            @Override
            public void add(int index, PersonDTO element) {

            }

            @Override
            public PersonDTO remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<PersonDTO> listIterator() {
                return null;
            }

            @Override
            public ListIterator<PersonDTO> listIterator(int index) {
                return null;
            }

            @Override
            public List<PersonDTO> subList(int fromIndex, int toIndex) {
                return null;
            }
        });
        this.mockMvc.perform(get("/person/list")).andDo(print());

        this.mockMvc.perform(get("/person/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("id")));

        this.mockMvc.perform(get("/training/person/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("id")));
    }
}