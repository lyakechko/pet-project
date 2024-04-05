CREATE TABLE p_core.product_customizes (
                                            product_id VARCHAR(255),
                                            user_id VARCHAR(50),
                                            name VARCHAR(200),
                                            sort_index integer,
                                            is_display_on_main BOOLEAN,
                                            is_main_payment_product BOOLEAN,
                                            is_balance_visible BOOLEAN,
                                            created_date TIMESTAMP,
                                            updated_date TIMESTAMP,

                                            CONSTRAINT product_customizes_pkey PRIMARY KEY (product_id, user_id)
);
CREATE INDEX product_customizes_id_index ON p_core.product_customizes(product_id);

CREATE TABLE p_core.block_customizes (
                                          user_id VARCHAR(50),
                                          block_customize_type VARCHAR(50),
                                          sort_index integer,
                                          is_visible BOOLEAN,
                                          show_total_amounts BOOLEAN,
                                          created_date TIMESTAMP,
                                          updated_date TIMESTAMP,

                                          CONSTRAINT block_customizes_pkey PRIMARY KEY (user_id, block_customize_type)
);
CREATE INDEX block_customizes_user_id_index ON p_core.block_customizes(user_id);