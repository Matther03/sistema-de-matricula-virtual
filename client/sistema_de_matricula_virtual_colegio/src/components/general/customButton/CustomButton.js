import { StyledButton } from "./styled";

const CustomButton = ({ text, variant, ...props }) => {
    return (
        <StyledButton 
            {...props}
            variant={variant || "contained"}>{text}</StyledButton>
    );
}
export default CustomButton;