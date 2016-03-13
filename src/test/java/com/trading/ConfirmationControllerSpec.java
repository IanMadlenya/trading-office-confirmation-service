package com.trading;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ConfirmationControllerSpec {

    private ConfirmationController confirmationController;

    private static final String DUMMY_ID = "DUMMY";

    private ConfirmationRepository confirmationRepository;

    @Before
    public void setUp() throws Exception {
        confirmationRepository = mock(ConfirmationRepository.class);

        ResolveUri resolveUri = mock(ResolveUri.class);
        when(resolveUri.path(any())).thenReturn(resolveUri);
        when(resolveUri.expandUri(any())).thenReturn(URI.create(DUMMY_ID));

        confirmationController = new ConfirmationController(confirmationRepository, resolveUri);
    }

    @Test
    public void pass_confirmation_to_confirmation_repository() throws Exception {

        Confirmation confirmation = mock(Confirmation.class);
        when(confirmation.getAllocationId()).thenReturn(DUMMY_ID);
        when(confirmationRepository.save(any(Confirmation.class))).thenReturn(confirmation);

        confirmationController.addConfirmation(confirmation);

        verify(confirmationRepository).save(confirmation);
    }

    @Test
    public void pass_query_by_id_to_confirmation_repository() throws Exception {

        confirmationController.getConfirmation(DUMMY_ID);

        verify(confirmationRepository).findOne(DUMMY_ID);
    }

    @Test
    public void returns_confirmation_for_given_id() throws Exception {

        Confirmation confirmation = mock(Confirmation.class);
        when(confirmationRepository.findOne(DUMMY_ID)).thenReturn(confirmation);

        Confirmation queriedConfirmation = confirmationController.getConfirmation(DUMMY_ID);

        assertThat(queriedConfirmation).isEqualTo(confirmation);
    }
}