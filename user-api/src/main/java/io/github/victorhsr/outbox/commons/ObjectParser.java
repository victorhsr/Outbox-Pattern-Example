package io.github.victorhsr.outbox.commons;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
public interface ObjectParser<InputType, OutputType> {

    OutputType parse(final InputType input);

}
